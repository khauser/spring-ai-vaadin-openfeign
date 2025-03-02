package com.example.ai.service;

import java.util.function.Consumer;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatService
{
    private final ChatClient chatClient;

    ChatService(ChatClient chatClient)
    {
        this.chatClient = chatClient;
    }

    public void chat(String chatId, String userQuestion, Consumer<String> consumer)
    {
        this.chatClient.prompt()
                       // .system(systemResource)
                       // .tools(aiDataProvider)
                       // .advisors(a -> a.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId))
                       .user(userQuestion)
                       .stream()
                       .content()
                       .doOnComplete(() -> log.info("[{}] Chat completed", chatId))
                       .onErrorComplete(err -> {
                           String message = String.format("[%s] Chat failed to answer question: %s", chatId,
                                           userQuestion);
                           log.error(message, err);
                           return true;
                       })
                       .subscribe(consumer);
    }
}

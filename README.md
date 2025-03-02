# spring-ai-vaadin-openfeign
Show case project with spring ai, vaadin and openfeign for creating an AI Chatbot extended with an external REST-interface (à la RAG).

## Start the application

* Add a valid openai api-key to the `application.yml`
* `./gradlew clean build`
* `./gradlew bootRun`
* Open `http://localhost:8080/vaadin-app/` in your browser and you should see the chat

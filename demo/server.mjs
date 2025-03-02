import express from "express";
import { createProxyMiddleware } from 'http-proxy-middleware';
import path from "path";

const app = express();
const port = 3000;

app.use('/vaadin-app', createProxyMiddleware({
  target: 'http://localhost:8080/vaadin-app',
  changeOrigin: true,
}));


app.use(express.static("public"));

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});

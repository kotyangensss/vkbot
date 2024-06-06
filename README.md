# VK Bot

Бот, написанный на Java, использующий Spring Boot. Бот возвращает сообщение отпраленное ему.

## Configuration

Для работы приложения нужно изменить файл application.yml, используя ваши данные 

```yaml
vk:
  group-id: YOUR_GROUP_ID
  confirmation-token: YOUR_CONFIRMATION_TOKEN
  access-token: YOUR_ACCESS_TOKEN
```

1. Зайти в управление группы vk.
2. Узнать id группы, вставить в group-id.
3. Создать access_token, вставить в access-token.
4. На вкладке Callback API получить confirmation-token.
5. Развернуть приложение на каком-либо домене, например используя ngrok.
6. Подтвердить Callback API, выдав разрешения на сообщения.
7. Написать сообщение сообществу.

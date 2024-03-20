# Серия лабораторных работ по предмету "Бизнес-логика программных систем"

Основная разработка ведется в ветке main. Ветки lab-1, lab-2, lab-3, lab-4 (пока есть только lab-1) обозначают границы каждой лабораторной работы. Например, на ветке lab-1 лежит готовая лабораторная работа №1.

## Тема проекта

Необходимо реализовать бизнес-процессы для сайта Litres. 

### Что уже реализовано?
- CRUD операции для читателя, автора и книги.
- Возрастные ограничения на книги + проверка возраста пользователя перед покупкой.
- Пагинация для GET-запросов, которые отдают списки.
- Единая авторизация для автора и читателя.
- При регистрации автор/читатель заполняет профиль, указывает сколько денег у него на "кошельке".
- Автор может создать книгу, заполнить необходимые поля и придумать стоимость для будущей книги. После создания книги (ее публикации) у автора списывается фиксированная стоимость за публикацию.
- Читатель может выбрать любую книгу, добавить ее себе (купить). Вместе с покупкой книги, у пользователя списывается стоимость книги, установленная автором, а автору приходят эти деньги на кошелек. 
- Все операции с деньгами являются транзакционными.
- Разграничен доступ к контроллерам читателя и автора. Только автор может создать книгу, только читатель ее может купить. 

### В процессе разработки
- что-то будет

## Технологии
- Spring Boot
- Lombok
- Swagger - при локальном развертывании ui лежит по адресу http://localhost:8080/swagger-ui/index.html#/
- Docker Compose
- PostgreSQL


## Задание. Spring. XML конфигурация

- Создать `application.properties` файл для подключения к БД
- Реализовать класс для подключения к БД
- Настроить `XML конфигурацию` так, чтобы репозитории получили соединение
- В методе main получить bean классов `UserService` и `CompanyService`
- Вызвать методы `findUserById` и `findCompanyById`

*Применено*:
- Gradle, Lombok
- Конфигурация beans в application.xml через конструктор
- Подключение к БД через JDBC (DriverManager), PostgresDriver

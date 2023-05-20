## Система Заметок. Реализация возможности создания, удаления и редактирования заметок.

Данный проект представляет собой сайт заметок, который реализован с использованием фреймворка Spring, а именно Spring MVC, Spring Boot. Также в проекте используется Bootstrap, популярный CSS фреймворк, для обеспечения современного и отзывчивого пользовательского интерфейса.

Веб-сайт позволяет пользователям создавать заметки и управлять ими. В проекте используется фреймворк Spring Boot, который позволяет легко установить и настроить приложение. В нем также используется Spring MVC для обеспечения веб-слоя. Функциональность заметок реализована с помощью RESTful API, что позволяет легко интегрировать их с другими приложениями. Заметки хранятся в базе данных MySQL, и проект использует Spring Data JPA для обеспечения доступа к базе данных.

Фронтенд приложения построен с использованием HTML, CSS и шаблонизатора Thymeleaf. В проекте также используется Bootstrap для обеспечения отзывчивого и современного пользовательского интерфейса.

## Настройка подключения к БД:
Port 3306
Username bestuser
Password bestuser
ДБ: joroboro_proj

## SQL commands:
CREATE TABLE `note` (
  `Id` int NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `note_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

wygenerowanie template MVC projektu spring na https://start.spring.io/
Aby nie instalować javy u siebie odpalam ją w dockerze.

pom.xml
Dodałem dependencies do Hibernate i DevTools
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>
```

w dockerfile
"-Dspring-boot.run.jvmArguments=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
Do podłączenia dev tools (np. vs code)

Dodane proste endpoint:
REST Api
w ./db_dane/init_data.sql sa przykładowe książki do zapełnienia bazy.

GET /proces -> zadanie 4.d
Uruchamia program 'sleep' na 1minutę, i zwraca stan procesu.

GET /ksiazki lub /ksiazki?autorId={id} -> zadanie 4.a, 4.b
Zwraca tablicę JSON książek, plus parametr autorId w celu wyszukania książek danego autora

GET /autorzy -> zadanie 4.b
Tablica wszystkich autorów 

GET /ksiazki/id -> zadanie 4.c
Pojedyńcza książka

GET /autorzy/id -> zadanie 4.c
Pijedyńczy autor

Uruchomienie (dev):
docker compose -f docker-compose.dev.yml up --build

Zbudowanie i uruchomienie (prod):
docker compose -f docker-compose.prod.yml up --build
# Etap 1: Budowanie (Builder)
# Używamy pełnego JDK i Mavena do skompilowania kodu i stworzenia JAR
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Kopiowanie zależności i kodu źródłowego
COPY pom.xml .
COPY src ./src

# Budowanie pliku JAR. Użycie -DskipTests jest standardowe w obrazach produkcyjnych.
RUN mvn clean package -DskipTests

# Etap 2: Produkcja (Runner)
# Używamy lekkiego obrazu zawierającego tylko JRE (Java Runtime Environment)
FROM eclipse-temurin:21-jre-alpine AS runner
WORKDIR /app

# Kopiowanie pliku JAR z etapu 'builder' do etapu 'runner'
# Nadanie stałej nazwy dla łatwiejszego odwołania
COPY --from=builder /app/target/*.jar app.jar

# Uruchomienie aplikacji w trybie produkcyjnym (do użycia przez docker-compose)
ENTRYPOINT ["java", "-jar", "app.jar"]
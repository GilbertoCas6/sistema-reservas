# Usa una imagen de Java 21 (o la versión que uses)
FROM eclipse-temurin:21-jdk

# Crea el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente
COPY src ./src

# Empaqueta la aplicación (genera el .jar)
RUN mvn clean package -DskipTests

# Expón el puerto
EXPOSE 8080

# Ejecuta el .jar
CMD ["java", "-jar", "target/sistema-reservas-0.0.1-SNAPSHOT.jar"]

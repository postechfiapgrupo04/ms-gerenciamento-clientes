# Usa a imagem Maven com Java 17
FROM maven:3.8.5-openjdk-17-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml primeiro para aproveitar o cache de dependências do Maven
COPY pom.xml .

# Baixa as dependências de compilação
RUN mvn dependency:go-offline

# Copia todo o código-fonte
COPY src ./src

# Compila o projeto e cria um JAR
RUN mvn package

# Copia o JAR construído para /app (ajustar o nome do arquivo conforme o que foi gerado pelo Maven)
COPY target/cliente-0.0.1-SNAPSHOT.jar /app/clientes.jar

# Porta a ser exposta
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "clientes.jar"]

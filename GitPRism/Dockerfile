# 🔹 1. 빌드 단계 (Builder Stage)
FROM openjdk:17-jdk-slim as builder

# 작업 디렉토리 설정
WORKDIR /app

# Gradle Wrapper와 프로젝트 관련 파일을 먼저 복사
COPY gradlew ./
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./

# Gradle 종속성 캐싱 (필수 의존성만 먼저 다운로드)
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon || true

# 애플리케이션 코드 복사 및 빌드
COPY . .
RUN ./gradlew bootJar --no-daemon

# 🔹 2. 실행 단계 (Final Stage)
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일 복사 (정확한 파일명 사용)
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 실행 포트 노출
EXPOSE 8080

# 실행 환경 변수 설정 (필요하면 추가 가능)
ENV SPRING_PROFILES_ACTIVE=prod

# 컨테이너 실행 시 JAR 파일 실행
CMD ["java", "-jar", "app.jar"]

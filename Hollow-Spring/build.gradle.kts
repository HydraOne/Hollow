plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
//    runtimeOnly("com.oracle.database.jdbc:ojdbc8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.2")
}
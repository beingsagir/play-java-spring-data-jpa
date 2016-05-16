name := """play-java-spring-data-jpa"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.springframework" % "spring-context" % "	4.2.4.RELEASE ",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework.data" % "spring-data-jpa" % "1.9.2.RELEASE",
  "org.springframework" % "spring-expression" % "4.2.4.RELEASE",
  "mysql" % "mysql-connector-java" % "5.1.18"
)

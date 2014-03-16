name := "aeMob"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  jdbc,
  "mysql" % "mysql-connector-java" % "5.1.27"
)     

play.Project.playJavaSettings

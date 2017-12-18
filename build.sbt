import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

javaSource in Compile := baseDirectory.value / "src"
javaSource in Test := baseDirectory.value / "test-src"

libraryDependencies += "com.sparkjava" % "spark-core" % "2.7.1"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25" % Test
libraryDependencies += "org.json" % "json" % "20171018"
libraryDependencies += "com.j256.ormlite" % "ormlite-jdbc" % "5.0"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.21.0"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

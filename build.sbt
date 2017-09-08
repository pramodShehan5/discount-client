name := "discountingclient-service"

description := "Discounting client"

enablePlugins(ServicePlugin)

libraryDependencies ++= Seq(
  "com.pagero" % "discounting-spec" % "0.1-SNAPSHOT" % "proto",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

parallelExecution in Test := false

parallelExecution in IntegrationTest := false

servicesToDeploy := Seq("etcd", "rabbitmq", "cassandra", "compliancedb")

//deployServicesExtraArgs := Seq("--force-update", "compliancedb")

plugins {
  java
  application
  id("com.gradleup.shadow") version "9.6.1"
}

group = "dev.crischutu07"

application {
  mainClass.set("${project.group}.MinestomServer.Main");
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("net.minestom:minestom:2026.07.22-26.2")
  // this is how you get rid of that annoying logger warning
  implementation("org.slf4j:slf4j-simple:2.0.9")
}

tasks {
  jar {
    enabled = false
  }

  startScripts {
    enabled = false
  }
  
  build {
    dependsOn(shadowJar)
  }
  
  shadowJar {
    manifest {
      attributes["Main-Class"] = "${project.group}.MinestomServer.Main"
    }
  }
}

java {
  toolchain.languageVersion = JavaLanguageVersion.of(25)
}

tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
}


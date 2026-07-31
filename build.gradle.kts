plugins {
    application
}

application {
    mainClass.set("dev.crischutu07.MinestomServer.Main");
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom:2026.07.22-26.2")
    // this is how you get rid of that annoying logger warning
    implementation("org.slf4j:slf4j-simple:2.0.9")
}

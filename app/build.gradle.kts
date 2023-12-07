plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.conectamovil01"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.conectamovil01"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.google.firebase:firebase-firestore:24.9.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // https://mvnrepository.com/artifact/de.hdodenhof/circleimageview
    implementation("de.hdodenhof:circleimageview:3.1.0")
    // https://mvnrepository.com/artifact/org.eclipse.paho/org.eclipse.paho.android.service
    implementation("org.eclipse.paho:org.eclipse.paho.android.service:1.1.1")
// https://mvnrepository.com/artifact/androidx.localbroadcastmanager/localbroadcastmanager
    runtimeOnly("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")

    // implementation("com.github.bumptech.glide:glide:5.0.0-rc01")
    //implementation ("com.basgeekball:awesome-validation:4.3")
    //implementation("id.zelory:compressor:3.0.1")
    //implementation ("com.karumi:dexter:6.2.3")
    //implementation("com.github.d-max:spots-dialog:0.7")
    //implementation("com.squareup.picasso:picasso:2.8")
}
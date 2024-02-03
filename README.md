# FabricMetadataWrap

Just basically easily wrap Fabric's metadata into something much shorter. Is this useless? Yes! Do I care? Nope.

Now is this a good idea? No. I'd say it's more abstracted now. Do I really care much? Nope, this was made out of Spite.

...but if you care about making your code look prettier... eh? I guess use this?

## Very Quick Example
### Java
```java
public class TestMod implements ModInitializer {
    public static final String MOD_ID = "testmod";

    // -------------------------
    // Instead of doing the full call
    public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().getFriendlyString();
    public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getName();


    // It would just be this
    public static final String VERSION = FMW.getVersionString(MOD_ID);
    public static final String MOD_NAME = FMW.getName(MOD_ID);
    // -------------------------
    
    @Override
    public void onInitialize() {
        LOGGER.info("[" + MOD_NAME + "] Version " + VERSION + " loaded.");
    }
}
```

### Kotlin
```kotlin
class TestMod : ModInitializer {
    companion object {
        val MOD_ID: String = "testmod"

        // -------------------------
        // Instead of doing the full call
        val MOD_VERSION: String = FabricLoader.getInstance().getModContainer(MOD_ID).get().metadata.version.friendlyString
        val MOD_NAME: String = FabricLoader.getInstance().getModContainer(MOD_ID).get().metadata.name
        
        // It would just be this
        val MOD_VERSION: String = FMW.getVersionString(MOD_ID)
        val MOD_NAME: String = FMW.getName(MOD_ID)
        // -------------------------

        override fun onInitialize() {
            LOGGER.info("${MOD_NAME} loaded! Version ${MOD_VERSION} loaded.")
        }
    }
}
```

## Adding to your Fabric project
FabricMetadataWrap is on devOS' Public Maven.

### Groovy
```groovy
repositories {
    maven { url = "https://mvn.devos.one/snapshots/" }
}

dependencies {
    include(modImplementation("gay.asoji:fmw:<version>"))
}
```
###### * This could be wrong, as I don't use Groovy anymore really, I'll check later ok byeeeeeeeeeee

### Kotlin DSL
```kotlin
repositories {
    maven { url = uri("https://mvn.devos.one/snapshots") }
}

dependencies {
    include(modImplementation("gay.asoji:fmw:<version>")!!)
}
```

## License
This project is licensed under the [MIT license](LICENSE).
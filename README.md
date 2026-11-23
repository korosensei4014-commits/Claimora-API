# Claimora API

The public API of **Claimora**, a land-claiming plugin for Paper 26.3. Use it to add Claimora support to
your plugin: check whether a player may build somewhere, read claims, give claim blocks, and listen to
claim events. This repository holds only the API (interfaces and events); the plugin itself is separate.

## Add it to your build

Gradle (Kotlin DSL):

```kotlin
repositories {
    maven("https://raw.githubusercontent.com/korosensei4014-commits/Claimora-API/repo/")
}

dependencies {
    compileOnly("com.korosensei.claimora:claimora-api:0.8.3")
}
```

Maven:

```xml
<repository>
  <id>claimora</id>
  <url>https://raw.githubusercontent.com/korosensei4014-commits/Claimora-API/repo/</url>
</repository>

<dependency>
  <groupId>com.korosensei.claimora</groupId>
  <artifactId>claimora-api</artifactId>
  <version>0.8.3</version>
  <scope>provided</scope>
</dependency>
```

Always `compileOnly` / `provided`: Claimora supplies these classes at runtime. The jar and sources are also
attached to each [release](https://github.com/korosensei4014-commits/Claimora-API/releases).
Built for Java 25 (Paper 26.3).

## Use it

Add `softdepend: [Claimora]` to your `plugin.yml`, then:

```java
ClaimoraApi api = ClaimoraApi.get(); // null if Claimora isn't installed or enabled
if (api != null && !api.canBuild(player, location)) {
    // Claimora protects this spot
}
```

Keep Claimora calls in a class that is only loaded when Claimora is present, so your plugin still works
without it.

| What | Methods / classes |
| --- | --- |
| Claims | `claimAt(Location)`, `claimById(long)`, `claimsOf(UUID owner)`, `ClaimInfo` (read-only) |
| Protection | `canBuild(Player, Location)` |
| Claim blocks | `availableBlocks(UUID)`, `giveClaimBlocks(UUID, long)` |
| Trust levels | `TrustLevel` (GUEST, CONTAINERS, BUILD, MANAGER) |
| Events | `ClaimCreateEvent`, `ClaimDeleteEvent`, `ClaimResizeEvent`, `ClaimTransferEvent`, `ClaimTrustEvent`, `ClaimTeleportEvent` |

Versions match Claimora's: API 0.8.3 belongs to Claimora 0.8.3. Changes stay backwards compatible within
the same minor version.

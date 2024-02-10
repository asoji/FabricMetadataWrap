package gay.asoji.fmw;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * FabricMetadataWrap library, basically easily wrapping Fabric's metadata into something much shorter.
 *
 * @author      asoji
 * @version     1.0.1
 * {@docRoot}
 */
public class FMW {
    /**
     * Gets metadata from modID's <code>src/main/resources/fabric.mod.json</code> file.
     * @param modID
     * @see <a href="https://fabricmc.net/wiki/documentation:fabric_mod_json_spec">fabric.mod.json specification</a>
     * @return FabricLoader.getInstance().getModContainer(modID).get().getMetadata()
     */
    public static ModMetadata getMetadata(String modID) {
        return FabricLoader.getInstance().getModContainer(modID).get().getMetadata();
    }

    /**
     * Gets <code>name</code> key from metadata as a String.
     * @param modID
     * @return "name" as a <code>String</code>
     */
    public static String getName(String modID) {
        return getMetadata(modID).getName();
    }

    /**
     * Gets <code>version</code> key from metadata as a String.
     * @param modID
     * @return "version" as a <code>String</code>
     */
    public static String getVersionString(String modID) {
        return getVersion(modID).getFriendlyString();
    }

    /**
     * Gets <code>version</code> key from metadata as a Version.
     * @param modID
     * @return "version" as a <code>Version</code>
     */
    public static Version getVersion(String modID) {
        return getMetadata(modID).getVersion();
    }

    /**
     * Gets <code>authors</code> key from metadata as an array.
     * @param modID
     * @return "authors" as a <code>Collection<Person></code>
     */
    public static Collection<Person> getAuthors(String modID) {
        return getMetadata(modID).getAuthors();
    }

    /**
     * Gets <code>contributors</code> key from metadata as an array.
     * @param modID
     * @return "contributors" as a <code>Collection<Person></code>
     */
    public static Collection<Person> getContributors(String modID) {
        return getMetadata(modID).getContributors();
    }

    /**
     * Gets <code>depends</code> key from metadata as an object.
     * See also {@link #getDepends(String)}
     * @param modID
     * @return "depends" as a <code>Collection<ModDependency></code>
     */
    public static Collection<ModDependency> getDependencies(String modID) {
        return getMetadata(modID).getDependencies();
    }

    /**
     * Gets <code>license</code> key from metadata as a string or array
     * @param modID
     * @return "license" as a <code>Collection<String></code>
     */
    public static Collection<String> getLicense(String modID) {
        return getMetadata(modID).getLicense();
    }

    public static Collection<String> getProvides(String modID) {
        return getMetadata(modID).getProvides();
    }

    /**
     * Gets the different kinds of dependency resolution from metadata as an object when paired with a specific kind
     * @param modID
     * @param kind
     */
    public static Collection<ModDependency> getKinds(String modID, ModDependency.Kind kind) {
        return getMetadata(modID).getDependencies().stream().filter(modDependency -> modDependency.getKind() == kind).toList();
    }

    /**
     * Gets <code>breaks</code> key from metadata as an object
     * @param modID
     * @return "breaks" as a <code>Collection<ModDependency></code>
     */
    public static Collection<ModDependency> getBreaks(String modID) {
        return getKinds(modID, ModDependency.Kind.BREAKS);
    }

    /**
     * Gets <code>conflicts</code> key from metadata as an object
     * @param modID
     * @return "conflicts" as a <code>Collection<ModDependency></code>
     */
    public static Collection<ModDependency> getConflicts(String modID) {
        return getKinds(modID, ModDependency.Kind.CONFLICTS);
    }

    /**
     * Gets <code>depends</code> key from metadata as an object
     * @param modID
     * @return "depends" as a <code>Collection<ModDependency></code>
     */
    public static Collection<ModDependency> getDepends(String modID) {
        return getKinds(modID, ModDependency.Kind.DEPENDS);
    }

    /**
     * Gets <code>recommends</code> key from metadata as an object
     * @param modID
     * @return "recommends" as a <code>Collection<ModDependency></code>
     */
    public static Collection<ModDependency> getRecommends(String modID) {
        return getKinds(modID, ModDependency.Kind.RECOMMENDS);
    }

    /**
     * Gets <code>suggests</code> key from metadata as an object
     * @param modID
     * @return "suggests" as a <code>Collection<ModDependency></code>
     */
    public static Collection<ModDependency> getSuggests(String modID) {
        return getKinds(modID, ModDependency.Kind.SUGGESTS);
    }

    public static Boolean containsCustomValue(String modID, String key) {
        return getMetadata(modID).containsCustomValue(key);
    }

    /**
     * Gets <code>contact</code> key from metadata as an object
     * @param modID
     * @return "contact" as <code>ContactInformation</code>
     */
    public static ContactInformation getContact(String modID) {
        return getMetadata(modID).getContact();
    }

    public static CustomValue getCustomValue(String modID, String key) {
        return getMetadata(modID).getCustomValue(key);
    }

    public static Map<String, CustomValue> getCustomValues(String modID) {
        return getMetadata(modID).getCustomValues();
    }

    /**
     * Gets <code>description</code> key from metadata as a string
     * @param modID
     * @return "description" as a <code>String</code>
     */
    public static String getDescription(String modID) {
        return getMetadata(modID).getDescription();
    }

    /**
     * Gets <code>environment</code> key from metadata as a string
     * @param modID
     * @return "environment" as a <code>ModEnvironment</code>
     */
    public static ModEnvironment getModEnvironment(String modID) {
        return getMetadata(modID).getEnvironment();
    }

    /**
     * Gets <code>icon</code> key from metadata as a string to icon path
     * @param modID
     * @return "icon" as a <code>Optional<String></code>
     */
    public static Optional<String> getIconPath(String modID, int size) {
        return getMetadata(modID).getIconPath(size);
    }

    /**
     * Gets <code>id</code> key from metadata as a string
     * @param modID
     * @return "id" as a <code>string</code>
     */
    public static String getId(String modID) {
        return getMetadata(modID).getId();
    }


    public static String getType(String modID) {
        return getMetadata(modID).getType();
    }
}

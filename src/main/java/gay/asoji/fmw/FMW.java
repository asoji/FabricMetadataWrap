package gay.asoji.fmw;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class FMW {
    public static ModMetadata getMetadata(String modID) {
        return FabricLoader.getInstance().getModContainer(modID).get().getMetadata();
    }

    public static String getName(String modID) {
        return getMetadata(modID).getName();
    }

    public static String getVersionString(String modID) {
        return getVersion(modID).getFriendlyString();
    }

    public static Version getVersion(String modID) {
        return getMetadata(modID).getVersion();
    }

    public static Collection<Person> getAuthors(String modID) {
        return getMetadata(modID).getAuthors();
    }

    public static Collection<Person> getContributors(String modID) {
        return getMetadata(modID).getContributors();
    }

    public static Collection<ModDependency> getDependencies(String modID) {
        return getMetadata(modID).getDependencies();
    }

    public static Collection<String> getLicense(String modID) {
        return getMetadata(modID).getLicense();
    }

    public static Collection<String> getProvides(String modID) {
        return getMetadata(modID).getProvides();
    }

    public static Collection<ModDependency> getKinds(String modID, ModDependency.Kind kind) {
        return getMetadata(modID).getDependencies().stream().filter(modDependency -> modDependency.getKind() == kind).toList();
    }

    public static Collection<ModDependency> getBreaks(String modID) {
        return getKinds(modID, ModDependency.Kind.BREAKS);
    }

    public static Collection<ModDependency> getConflicts(String modID) {
        return getKinds(modID, ModDependency.Kind.CONFLICTS);
    }

    public static Collection<ModDependency> getDepends(String modID) {
        return getKinds(modID, ModDependency.Kind.DEPENDS);
    }

    public static Collection<ModDependency> getRecommends(String modID) {
        return getKinds(modID, ModDependency.Kind.RECOMMENDS);
    }

    public static Collection<ModDependency> getSuggests(String modID) {
        return getKinds(modID, ModDependency.Kind.SUGGESTS);
    }

    public static Boolean containsCustomValue(String modID, String key) {
        return getMetadata(modID).containsCustomValue(key);
    }

    public static ContactInformation getContact(String modID) {
        return getMetadata(modID).getContact();
    }

    public static CustomValue getCustomValue(String modID, String key) {
        return getMetadata(modID).getCustomValue(key);
    }

    public static Map<String, CustomValue> getCustomValues(String modID) {
        return getMetadata(modID).getCustomValues();
    }

    public static String getDescription(String modID) {
        return getMetadata(modID).getDescription();
    }

    public static ModEnvironment getModEnvironment(String modID) {
        return getMetadata(modID).getEnvironment();
    }

    public static Optional<String> getIconPath(String modID, int size) {
        return getMetadata(modID).getIconPath(size);
    }

    public static String getId(String modID) {
        return getMetadata(modID).getId();
    }

    public static String getType(String modID) {
        return getMetadata(modID).getType();
    }
}

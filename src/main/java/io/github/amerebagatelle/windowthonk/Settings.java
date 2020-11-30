package io.github.amerebagatelle.windowthonk;

import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    public static final Settings INSTANCE = new Settings();

    public boolean changeWMClass = true;
    public boolean changeWindowTitle = true;
    public boolean openOnHoveredMonitor = true;

    public Settings() {
        File settingsFile = FabricLoader.getInstance().getConfigDir().resolve("windowthonk.properties").toFile();

        Properties properties = new Properties();
        try {
            if (!settingsFile.exists()) {
                settingsFile.createNewFile();
            }
            properties.load(new FileReader(settingsFile));
            changeWMClass = Boolean.parseBoolean(properties.getProperty("changeWMClass", Boolean.toString(true)));
            changeWindowTitle = Boolean.parseBoolean(properties.getProperty("changeWindowTitle", Boolean.toString(true)));
            openOnHoveredMonitor = Boolean.parseBoolean(properties.getProperty("openOnHoveredMonitor", Boolean.toString(true)));
        } catch (IOException ignored) {
        }

    }
}

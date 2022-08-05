package dev.aarow.home.managers;

import dev.aarow.home.HomePlugin;

public abstract class Manager {

    public HomePlugin plugin = HomePlugin.INSTANCE;

    public abstract void setup();
}

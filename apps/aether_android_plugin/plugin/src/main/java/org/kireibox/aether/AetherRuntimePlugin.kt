package org.kireibox.aether

import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin

class AetherRuntimePlugin(
    godot: Godot
) : GodotPlugin(godot) {

    companion object {
        init {
            System.loadLibrary("aether_kiri_godot")
        }
    }

    override fun getPluginName(): String = "AetherRuntime"

    override fun getPluginGDExtensionLibrariesPaths(): Set<String> =
        setOf("res://addons/AetherRuntime/aether_kiri.gdextension")
}

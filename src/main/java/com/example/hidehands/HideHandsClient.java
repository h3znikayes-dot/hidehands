package com.example.hidehands;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class HideHandsClient implements ClientModInitializer {
	public static final String MOD_ID = "hidehands";

	public static final KeyMapping.Category CATEGORY =
			KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MOD_ID, "main"));

	public static KeyMapping hideHandsKey;

	@Override
	public void onInitializeClient() {
		hideHandsKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.hidehands.hide_hands",
				InputConstants.Type.KEYSYM,
				GLFW.GLFW_KEY_F,
				CATEGORY
		));
	}

	/** True while the key is physically held down (works with rebinding). */
	public static boolean shouldHideHands() {
		return hideHandsKey != null && hideHandsKey.isDown();
	}
}

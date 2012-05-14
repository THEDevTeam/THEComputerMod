package com.thedevteam.thecomputermod.materials;

import java.lang.reflect.Field;

import org.spout.api.material.Material;
import org.spout.vanilla.material.VanillaMaterial;

import com.thedevteam.thecomputermod.materials.blocks.Computer;

public final class CMMaterials {
	private static boolean initialized = false;
	
	public static final Computer COMPUTER = (Computer) Material.register(new Computer("Computer", 400).setHardness(1.5F).setResistance(10.0F));
	
	public static void initialize() {
		if (initialized ) {
			return;
		}
		for (Field field : CMMaterials.class.getFields()) {
			try {
				if (field == null || !CMMaterials.class.isAssignableFrom(field.getType())) {
					continue;
				}
				VanillaMaterial material = (VanillaMaterial) field.get(null);
				if (material == null) {
					System.out.println("Vanilla Material field '" + field.getName() + "' is not yet initialized");
					continue;
				}
//				try {
//					material.loadProperties();
//				} catch (Throwable t) {
//					System.out.println("An exception occurred while loading the properties of Vanilla Material '" + field.getName() + "':");
//					t.printStackTrace();
//				}
			} catch (NullPointerException ex) {
				continue; //ignore local fields
			} catch (Throwable t) {
				System.out.println("An exception occurred while reading Vanilla Material field '" + field.getName() + "':");
				t.printStackTrace();
			}
		}
		initialized = true;
	}
}

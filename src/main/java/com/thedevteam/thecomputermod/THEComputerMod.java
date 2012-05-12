package com.thedevteam.thecomputermod;

import java.util.logging.Level;

import org.spout.api.plugin.CommonPlugin;


public class THEComputerMod extends CommonPlugin{

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		log(Level.INFO, "THEIndustrialMod has been enabled");
	}

	public void log(Level warning, String string) {
		getLogger().log(warning, string);
	}

}

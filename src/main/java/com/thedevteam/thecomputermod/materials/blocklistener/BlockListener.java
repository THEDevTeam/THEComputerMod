package com.thedevteam.thecomputermod.materials.blocklistener;

import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.Order;
import org.spout.api.event.player.PlayerInteractEvent;

import com.thedevteam.thecomputermod.THEComputerMod;

public class BlockListener implements Listener {
	THEComputerMod main = null;

	public BlockListener(THEComputerMod main) {
		this.main = main;
	}

	@EventHandler(order = Order.EARLY)
	void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getInteractedPoint().getWorld().getBlock(e.getInteractedPoint())
				.getMaterial().getId() == 1) {
			e.getPlayer().chat("Clicked stone");
		}
	}
}

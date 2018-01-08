package com.pam.harvestcraft.gui;

import org.lwjgl.opengl.GL11;

import com.pam.harvestcraft.tileentities.TileEntityApiary;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiApiary extends GuiContainer {
    private static final ResourceLocation gui = new ResourceLocation("harvestcraft:textures/gui/apiary.png");

    public GuiApiary(InventoryPlayer invPlayer, TileEntityApiary apiaryTileEntity) {
        super(new ContainerApiary(invPlayer, apiaryTileEntity));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString("Apiary", 8, 8, 4210752);
        fontRenderer.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 4, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(gui);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}
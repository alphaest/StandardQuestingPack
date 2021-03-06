package bq_standard.client.gui.rewards;

import betterquesting.api.client.gui.GuiElement;
import betterquesting.api.client.gui.misc.IGuiEmbedded;
import bq_standard.rewards.RewardScoreboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.TextFormatting;

public class GuiRewardScoreboard extends GuiElement implements IGuiEmbedded
{
	private RewardScoreboard reward;
	private Minecraft mc;
	
	private int posX = 0;
	private int posY = 0;
	private int sizeX = 0;
	private int sizeY = 0;
	
	public GuiRewardScoreboard(RewardScoreboard reward, int posX, int posY, int sizeX, int sizeY)
	{
		this.mc = Minecraft.getMinecraft();
		this.reward = reward;
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	@Override
	public void drawBackground(int mx, int my, float partialTick)
	{
		String txt1 = reward.score;
		String txt2 = "" + TextFormatting.BOLD;
		
		if(!reward.relative)
		{
			txt2 += "= " + reward.value;
		} else if(reward.value >= 0)
		{
			txt2 += TextFormatting.GREEN + "+ " + Math.abs(reward.value);
		} else
		{
			txt2 += TextFormatting.RED + "- " + Math.abs(reward.value);
		}
		
		GlStateManager.pushMatrix();
		GlStateManager.scale(1.5F, 1.5F, 1F);
		mc.fontRenderer.drawString(txt1, (int)((posX + sizeX/2 - mc.fontRenderer.getStringWidth(txt1)/1.5F)/1.5F), (int)((posY + sizeY/2 - 16)/1.5F), getTextColor(), false);
		mc.fontRenderer.drawString(txt2, (int)((posX + sizeX/2 - mc.fontRenderer.getStringWidth(txt2)/1.5F)/1.5F), (int)((posY + sizeY/2)/1.5F), getTextColor(), false);
		GlStateManager.popMatrix();
	}

	@Override
	public void drawForeground(int mx, int my, float partialTick)
	{
	}

	@Override
	public void onMouseClick(int mx, int my, int click)
	{
	}

	@Override
	public void onMouseScroll(int mx, int my, int scroll)
	{
	}

	@Override
	public void onKeyTyped(char c, int keyCode)
	{
	}
}

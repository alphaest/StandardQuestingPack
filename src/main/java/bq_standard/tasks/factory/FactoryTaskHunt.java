package bq_standard.tasks.factory;

import betterquesting.api.enums.EnumSaveType;
import betterquesting.api.misc.IFactory;
import bq_standard.core.BQ_Standard;
import bq_standard.tasks.TaskHunt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public final class FactoryTaskHunt implements IFactory<TaskHunt>
{
	public static final FactoryTaskHunt INSTANCE = new FactoryTaskHunt();
	
	private FactoryTaskHunt()
	{
	}
	
	@Override
	public ResourceLocation getRegistryName()
	{
		return new ResourceLocation(BQ_Standard.MODID + ":hunt");
	}

	@Override
	public TaskHunt createNew()
	{
		return new TaskHunt();
	}

	@Override
	public TaskHunt loadFromNBT(NBTTagCompound json)
	{
		TaskHunt task = new TaskHunt();
		task.readFromNBT(json, EnumSaveType.CONFIG);
		return task;
	}
	
}

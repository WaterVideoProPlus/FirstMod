package com.AlanMiller.firstmod.item;

import com.AlanMiller.firstmod.FirstMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final String FIRST_TAB_STRING = "creativetab.first_tab";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIRST_TAB = CREATIVE_MODE_TABS.register("first_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable(FIRST_TAB_STRING))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());

                        pOutput.accept(Items.LAPIS_LAZULI);
                        pOutput.accept(Items.DIAMOND);
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
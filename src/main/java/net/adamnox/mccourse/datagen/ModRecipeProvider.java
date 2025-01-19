package net.adamnox.mccourse.datagen;

import net.adamnox.mccourse.MCCourseMod;
import net.adamnox.mccourse.block.ModBlocks;
import net.adamnox.mccourse.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BLACK_OPAL_SMELTABLES = List.of(ModItems.RAW_BLACK_OPAL,
                ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_END_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                .unlockedBy("has_black_opal_block", has(ModBlocks.BLACK_OPAL_BLOCK.get())).save(recipeOutput);

        oreSmelting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal");
        oreBlasting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 100, "black_opal");

        stairBuilder(ModBlocks.BLACK_OPAL_STAIRS.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                        .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_SLAB.get(), ModItems.BLACK_OPAL.get());

        pressurePlate(recipeOutput, ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get(), ModItems.BLACK_OPAL.get());
        buttonBuilder(ModBlocks.BLACK_OPAL_BUTTON.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        fenceBuilder(ModBlocks.BLACK_OPAL_FENCE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLACK_OPAL_FENCE_GATE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_WALL.get(), ModItems.BLACK_OPAL.get());

        doorBuilder(ModBlocks.BLACK_OPAL_DOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BLACK_OPAL_TRAPDOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_SWORD.get())
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_PICKAXE.get())
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_SHOVEL.get())
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_AXE.get())
                .pattern(" BB")
                .pattern(" SB")
                .pattern(" S ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_HOE.get())
                .pattern("BB ")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_PAXEL.get())
                .pattern("AHP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.BLACK_OPAL_PICKAXE.get())
                .define('A', ModItems.BLACK_OPAL_AXE.get())
                .define('H', ModItems.BLACK_OPAL_SHOVEL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACK_OPAL_HAMMER.get())
                .pattern(" BS")
                .pattern(" SB")
                .pattern("S  ")
                .define('B', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_HELMET.get())
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_CHESTPLATE.get())
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_LEGGINGS.get())
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_OPAL_BOOTS.get())
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_block_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        trimSmithing(recipeOutput, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "kaupen"));
    }
}

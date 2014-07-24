package ro.thehunters.digi.recipeManager;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public enum Messages {
	// Flags

	FLAG_OVERRIDE(null), //"<yellow>Overwrites another recipe."),

	FLAG_RESTRICT(null), //"<red>Recipe is disabled."),

	FLAG_HOLDITEM(null), //"<red>Need to hold: <yellow>{items}"),

	FLAG_GAMEMODE(null), //"<red>Allowed gamemodes: <yellow>{gamemodes}"),

	FLAG_HEIGHT(null), //"<red>Need height: <yellow>{height}"),

	FLAG_ONLINETIME(null), //"<red>Need online time: <yellow>{range}"),

	FLAG_PERMISSION_ALLOWED(null), //"<red>Allowed permissions: <yellow>{permissions}"),
	FLAG_PERMISSION_UNALLOWED(null), //"<red>Unallowed permissions: <yellow>{permissions}"),

	FLAG_GROUP_ALLOWED(null), //"<red>Allowed groups: <yellow>{groups}"),
	FLAG_GROUP_UNALLOWED(null), //"<red>Unallowed groups: <yellow>{groups}"),

	FLAG_WORLD_ALLOWED(null), //"<red>Allowed worlds: <yellow>{worlds}"),
	FLAG_WORLD_UNALLOWED(null), //"<red>Unallowed worlds: <yellow>{worlds}"),

	FLAG_WEATHER(null), //"<red>Needs weather: <yellow>{weather}"),

	FLAG_BIOME_ALLOWED(null), //"<red>Allowed biomes: <yellow>{biomes}"),
	FLAG_BIOME_UNALLOWED(null), //"<red>Unallowed biomes: <yellow>{biomes}"),

	FLAG_RETURNITEM_RETURNED(null), //"<green>Returned item {item}<green> in crafting grid."),
	FLAG_RETURNITEM_MERGED(null), //"<green>Returned item {item}<green> merged in crafting grid."),
	FLAG_RETURNITEM_RECIEVED(null), //"<yellow>Returned item {item}<green> added to inventory."),
	FLAG_RETURNITEM_DROPPED(null), //"<yellow>Returned item {item}<green> dropped."),

	FLAG_BLOCKPOWERED_FURNACE(null), //"<red>Need a furnace powered by redstone."),
	FLAG_BLOCKPOWERED_WORKBENCH(null), //"<red>Need a workbench powered by redstone."),

	FLAG_LIGHTLEVEL(null), //"<red>Need to be in <yellow>{light}<red> levels of <yellow>{type}<red>."),

	FLAG_SETBLOCK_NEEDSWORKBENCH(null), //"<red>Recipe needs to be used with a workbench!"),

	FLAG_ITEMS(null), //"<red>Need in inventory: <yellow>{items}"),
	FLAG_NOITEMS(null), //"<red>Unallowed in inventory: <yellow>{items}"),
	FLAG_EQUIP(null), //"<red>Need equipped: <yellow>{items}"),
	FLAG_NOEQUIP(null), //"<red>Unallowed equipped: <yellow>{items}"),
	FLAG_HOLD(null), //"<red>Need in hand: <yellow>{items}"),
	FLAG_NOHOLD(null), //"<red>Unallowed in hand: <yellow>{items}"),

	FLAG_COMMAND_PLAYER(null), //"Executes command on crafter: <yellow>{command}"),
	FLAG_COMMAND_SERVER(null), //"Executes console command: <yellow>{command}"),

	FLAG_INGREDIENTCONDITIONS_NODATA(null), //"<yellow>{item}<red> needs data values: <yellow>{data}"),
	FLAG_INGREDIENTCONDITIONS_NOAMOUNT(null), //"<yellow>{item}<red> needs amount: <yellow>{amount}"),
	FLAG_INGREDIENTCONDITIONS_NOENCHANTS(null), //"<yellow>{item}<red> needs enchantments: <yellow>{enchants}"),
	FLAG_INGREDIENTCONDITIONS_NONAME(null), //"<yellow>{item}<red> needs name: <yellow>{name}"),
	FLAG_INGREDIENTCONDITIONS_NOLORE(null), //"<yellow>{item}<red> needs lore: <yellow>{lore}"),
	FLAG_INGREDIENTCONDITIONS_NOCOLOR(null), //"<yellow>{item}<red> needs color: <yellow>{color}"),

	FLAG_NEEDEXP(null), //"<red>Need EXP: <yellow>{exp}"),

	FLAG_MODEXP_ADD(null), //"<green>+{amount}<reset> EXP"),
	FLAG_MODEXP_SUB(null), //"<yellow>-{amount}<reset> EXP"),
	FLAG_MODEXP_SET(null), //"<reset>EXP set to <yellow>{amount}"),

	FLAG_NEEDLEVEL(null), //"<red>Need level: <yellow>{level}"),

	FLAG_MODLEVEL_ADD(null), //"<green>+{amount}<reset> level(s)"),
	FLAG_MODLEVEL_SUB(null), //"<red>-{amount}<reset> level(s)"),
	FLAG_MODLEVEL_SET(null), //"<reset>Level set to <yellow>{amount}"),

	FLAG_NEEDMONEY(null), //"<red>Need money: <yellow>{money}"),

	FLAG_MODMONEY_ADD(null), //"<green>+{money}"),
	FLAG_MODMONEY_SUB(null), //"<red>-{money}"),
	FLAG_MODMONEY_SET(null), //"<reset>Money set to <yellow>{money}"),

	FLAG_PLAYERBUKKITMETA(null), //"<red>You need to be special..."),
	FLAG_NOPLAYERBUKKITMETA(null), //"<red>You're too special..."),

	FLAG_BLOCKBUKKITMETA(null), //"<red>Needs special block..."),
	FLAG_NOBLOCKBUKKITMETA(null), //"<red>Block to special..."),

	FLAG_POTIONEFFECTS(null), //"<red>Need potion effect: {effects}"),
	FLAG_NOPOTIONEFFECTS(null), //"<red>Unallowed potion effect: {effects}"),

	FLAG_REALTIME(null), //"<red>Allowed between {mindate} and {maxdate}"),

	FLAG_COOLDOWN_FAIL_PERPLAYER(null), //"<red>Personal cooldown: {time}"),
	FLAG_COOLDOWN_FAIL_GLOBAL(null), //"<red>Global cooldown: {time}"),
	FLAG_COOLDOWN_SET_PERPLAYER(null), //"<yellow>Personal cooldown set to {time}"),
	FLAG_COOLDOWN_SET_GLOBAL(null), //"<yellow>Global cooldown set to {time}"),

	FLAG_CLONE_RESULTDISPLAY(null), //"<dark_aqua><italic>(clone)"),

	FLAG_PREFIX_RECIPE(null), //"<gray>(Recipe) <reset>"),
	FLAG_PREFIX_RESULT(null), //"<gray>(Result {item}<gray>) <reset>"),
	FLAG_PREFIX_FURNACE(null), //"<gray>(Furnace {location}) <reset>"),

	// Crafting

	CRAFT_REPAIR_DISABLED(null), //"<red>Repair recipes disabled."),

	CRAFT_SPECIAL_LEATHERDYE(null), //"<red>Leather dyeing is disabled."),
	CRAFT_SPECIAL_FIREWORKS(null), //"<red>Firework crafting is disabled."),
	CRAFT_SPECIAL_MAP_CLONING(null), //"<red>Map cloning is disabled."),
	CRAFT_SPECIAL_MAP_EXTENDING(null), //"<red>Map extending is disabled."),

	CRAFT_RESULT_DENIED_TITLE(null), //"<yellow>You can't craft this recipe!"),
	CRAFT_RESULT_DENIED_INFO(null), //"<green>See chat for reasons."),
	CRAFT_RESULT_NORECIEVE_TITLE(null), //"<yellow>You can't craft any results from this recipe!"),
	CRAFT_RESULT_NORECIEVE_INFO(null), //"<green>See chat for reasons."),
	CRAFT_RESULT_RECIEVE_TITLE_UNKNOWN(null), //"<light_purple>You will get an unknown item!"),
	CRAFT_RESULT_RECIEVE_TITLE_RANDOM(null), //"<light_purple>You will get a random item:"),
	CRAFT_RESULT_LIST_ITEM(null), //"<dark_green>{chance} <green>{item} {clone}"),
	CRAFT_RESULT_LIST_SECRETS(null), //"<dark_aqua>{num} secret item(s)"),
	CRAFT_RESULT_LIST_FAILURE(null), //"<red>{chance} Failure chance"),
	CRAFT_RESULT_LIST_UNAVAILABLE(null), //"<dark_red>{num} unavailable item(s)"),

	CRAFT_RECIPE_MULTI_FAILED(null), //"<yellow>NOTE: <white>That sound was the recipe failing by chance! See 'fail chance' in the result description."),
	CRAFT_RECIPE_MULTI_NOSHIFTCLICK(null), //"<yellow>NOTE: <white>Recipe has more than one result, shift+clicking will only craft it once."),
	CRAFT_RECIPE_MULTI_CURSORFULL(null), //"<yellow>NOTE: <white>Cursor is full or not same type as result, put the held item in inventory or use Shift+Click to craft one by one to inventory."),

	CRAFT_RECIPE_FLAG_NOSHIFTCLICK("<yellow>NOTE: <white>Recipe is special, shift-clicking will only craft it once."),

	SMELT_FUEL_NEEDINGREDIENT(null), //"<red>Fuel {fuel}<red> needs specific ingredient: {ingredient}"),
	SMELT_FUEL_NEEDFUEL(null), //"<red>Ingredient {ingredient}<red> needs specific fuel: {fuel}"),

	SMELT_FROZEN(null), //"<red>Furnace at <yellow>{location} <red>will be frozen until you re-place the ingredient."),

	ITEM_ANYDATA(null), //"<gray>any"),

	RECIPEBOOK_VOLUME("Volume {volume}"),
	RECIPEBOOK_VOLUMEOFVOLUMES("Volume {volume} of {volumes}"),
	RECIPEBOOK_HEADER_CONTENTS("<gold><italic>Contents Index"),
	RECIPEBOOK_HEADER_SHAPED("<gold><italic>Recipe"),
	RECIPEBOOK_HEADER_SHAPELESS("<gold><italic>Shapeless Recipe"),
	RECIPEBOOK_HEADER_SMELT("<black>Furnace Recipe"),
	RECIPEBOOK_HEADER_FUEL("<black>Furnace Fuel"),
	RECIPEBOOK_HEADER_SHAPE("<black>Shape"),
	RECIPEBOOK_HEADER_INGREDIENTS("<black>Ingredients"),
	RECIPEBOOK_HEADER_INGREDIENT("<black>Ingredient"),
	RECIPEBOOK_HEADER_COOKTIME("<black>Cooking time"),
	RECIPEBOOK_HEADER_BURNTIME("<black>Burning time"),
	RECIPEBOOK_HEADER_REQUIREFUEL("<black>As fuel"),
	RECIPEBOOK_MORERESULTS("<dark_green>+{amount} more results"),
	RECIPEBOOK_SMELT_TIME_NORMAL("<black><gray>({time} seconds)"),
	RECIPEBOOK_SMELT_TIME_INSTANT("<dark_green>Instant <gray>(0 seconds)"),
	RECIPEBOOK_SMELT_TIME_FIXED("<red>{time} <black>seconds"),
	RECIPEBOOK_SMELT_TIME_RANDOM("<red>{min} <black>to <red>{max} <black>seconds"),
	RECIPEBOOK_FUEL_TIME_FIXED("<dark_green>{time} <black>seconds"),
	RECIPEBOOK_FUEL_TIME_RANDOM("<dark_green>{min} <black>to <dark_green>{max} <black>seconds"),
	RECIPEBOOK_UPDATE_EXTINCT("<red>Your '<yellow>{title}<red>' recipe book does not exist anymore, it won't be updated further."),
	RECIPEBOOK_UPDATE_NOVOLUME("<red>Your '<yellow>{title}<red>' recipe book does not have <yellow>volume {volume}<red> anymore, it won't be updated further."),
	RECIPEBOOK_UPDATE_DONE("<gray>Your held recipe book has been updated!"),
	RECIPEBOOK_UPDATE_CHANGED_TITLE("<gray>Title changed from '<reset>{oldtitle}<gray>' to '<reset>{newtitle}<gray>'."),
	RECIPEBOOK_UPDATE_CHANGED_PAGES("<gray>Pages change from <red>{oldpages}<gray> pages to <green>{newpages}<gray> pages."),

	CMD_GETBOOK_INVALIDNUMBER("<red>Volume argument must be a number!"),
	CMD_GETBOOK_NOTEXIST("<red>No books found by '{arg}'."),
	CMD_GETBOOK_MANYMATCHES("<red>Found {num} books by '{arg}':"),
	CMD_GETBOOK_GIVEN("<gold>Got book: {title}"),

	CMD_BOOKS_NOBOOKS("<red>No generated books."),
	CMD_BOOKS_HEADER("<gold>Generated recipe books ({number}):"),
	CMD_BOOKS_ITEM("<gold>{title} <gray>(volumes: {volumes})"),

	CMD_EXTRACT_WAIT("<red>Command re-used too fast, wait a second."),
	CMD_EXTRACT_UNKNOWNARG("<red>Unknown argument: <yellow>{arg}"),
	CMD_EXTRACT_CONVERTING("<gray>Searching and converting recipes..."),
	CMD_EXTRACT_NORECIPES("<yellow>No recipes to extract."),
	CMD_EXTRACT_DONE("<green>Done! Recipes saved to '<white>{file}<green>'."),

	CMD_RECIPES_USAGE("<gold>Usage: <gray>/{command} <material>:[data]:[amount]"),
	CMD_RECIPES_STATS_MC("<gold>Recipe:"),
	CMD_RECIPES_STATS_RM("<gold>Recipe:"),
	CMD_RECIPES_STATS_OTHER("<gold>Recipe:"),
	CMD_RECIPES_HEADER("<gold>===== <white>Recipes for <green>{item} <gold>(<blue>{num} <gold>of <blue>{total}) ====="),
	CMD_RECIPES_MORE("<gold>===== <blue>{cmdnext} <gold>for next, <blue>{cmdprev} <gold>for previous<gold> ====="),
	CMD_RECIPES_END("<gold>===== No more recipes ====="),
	CMD_RECIPES_NONEXT("<red>No more recipes next, type <blue>{command} <red>to see the previous recipe."),
	CMD_RECIPES_NOPREV("<red>Can't go backwards more than this, type {command} <red>to see the next recipe."),
	CMD_RECIPES_NEEDQUERY("<red>No search progress! Use the command with an item name to search."),
	CMD_RECIPES_NORESULTS("<red>No results for {item}!"),
	CMD_RECIPES_NOHAND("<red>You don't have anything in your hand therefore you can't use the 'this' argument."),
	CMD_RECIPES_INVALIDITEM("<red>Invalid item: '{arg}'!"),

	CMD_FINDITEM_USAGE("<gold>Usage: <gray>/{command} <item partial name>"),
	CMD_FINDITEM_INVALIDHELDITEM("<gold>You need to hold an item to use the 'this' argument."),
	CMD_FINDITEM_HEADER("<gold>Found <blue>{matches}<gold> materials matching '<blue>{argument}<gold>':"),
	CMD_FINDITEM_LIST("<gold>#<red>{id}: <red>{material}<gold>, max durability <red>{maxdata}<gold>, max stack <red>{maxstack}<gold>."),
	CMD_FINDITEM_FOUNDMORE("<gold>... and <blue>{matches}<gold> more, be more specific in your search."),
	CMD_FINDITEM_NOTFOUND("<red>No material found by '{argument}'."),

	LASTCHANGED(null);

	private static final Map<String, Set<String>> sent = new HashMap<String, Set<String>>();

	//private static FileConfiguration yml;

	private String path;

	private String message;

	private Messages(String message) {

		this.path = name().replace('_', '.').toLowerCase();
		this.message = message;
	}

	/* private void asign() { /message = yml.getString(path, message); // get
	 * the message or use the predefined one if doesn't exist
	 * 
	 * if(message != null && (message.isEmpty() || message.equals("false"))) {
	 * message = null; // disable message if empty or 'false' } } */

	/**
	 * (Re)Loads all messages
	 * 
	 * @param force
	 */
	public static void reload(CommandSender sender) {

		sender.sendMessage("Message configuration is disabled.");
		/*File file = new File(RecipeManager.getPlugin().getDataFolder() +
		 * File.separator + Files.FILE_MESSAGES);
		 * 
		 * if(!file.exists()) { yml = new YamlConfiguration();
		 * yml.options().header(
		 * "Configurable messages.\nParts surrounded by { and } are variables that get replaced in-game, you can move them around or even remove them if you want.\nTo disable messages you can just delete the message or use 'false'."
		 * ); yml.options().copyHeader(true);
		 * 
		 * for(Messages msg : values()) { yml.set(msg.path, msg.message); }
		 * 
		 * yml.set("lastchanged", Files.LASTCHANGED_MESSAGES);
		 * 
		 * try { yml.save(file); } catch(Throwable e) { error(sender, e,
		 * "Couldn't save '" + Files.FILE_MESSAGES + "' file!"); }
		 * 
		 * sendAndLog(sender, ChatColor.GREEN + "Generated '" +
		 * Files.FILE_MESSAGES + "' file."); } else { yml =
		 * YamlConfiguration.loadConfiguration(file); }
		 * 
		 * for(Messages msg : values()) { msg.asign(); }
		 * 
		 * if(LASTCHANGED == null || LASTCHANGED.message == null ||
		 * !LASTCHANGED.message.equals(Files.LASTCHANGED_MESSAGES)) {
		 * sendAndLog(sender, "<yellow>NOTE: <reset>'" + Files.FILE_MESSAGES +
		 * "' file is outdated, please delete it to allow it to be generated again."
		 * ); } */
	}

	/**
	 * Gets the message for the selected enum.<br>
	 * Processes colors as well.
	 * 
	 * @return
	 */
	public String get() {

		return Tools.parseColors(message, false);
	}

	@Override
	public String toString() {

		return get();
	}

	/**
	 * Gets the message for the selected enum.<br>
	 * Processes colors and variables as well.
	 * 
	 * @return
	 */
	public String get(Object... variables) {

		return Tools.replaceVariables(Tools.parseColors(message, false), variables);
	}

	public String getCustom(String customMessage, Object... variables) {

		String msg = get();

		if (customMessage != null) // has custom message
		{
			// if flag message is set to "false" then don't show the message
			msg = (customMessage.equals("false") ? null : customMessage);
		}
		else if (msg != null && msg.equals("false")) {
			// message is "false", don't show the message
			msg = null;
		}

		return msg == null ? null : Tools.replaceVariables(msg, variables);
	}

	/**
	 * Send the selected enum message to a player or console. <br>
	 * Will not be displayed if the message is set to "false".
	 * 
	 * @param sender
	 *            player or console
	 */
	public void print(CommandSender sender) {

		if (sender == null) {
			return;
		}

		if (message != null) {
			send(sender, message);
		}
	}

	/**
	 * Send the selected enum message to a player or console with an
	 * overwriteable message.<br>
	 * The customMessage has priority if it's not null.<br>
	 * If the priority message is "false" it will not be displayed.
	 * 
	 * @param sender
	 *            player or console
	 * @param customMessage
	 *            overwrite message, ignored if null, don't display if "false"
	 */
	public void print(CommandSender sender, String customMessage) {

		if (sender == null) {
			return;
		}

		if (customMessage != null) // has custom message ?
		{
			if (!customMessage.equals("false")) // if it's not "false" send it, otherwise don't.
			{
				send(sender, customMessage);
			}
		}
		else if (message != null) // message not set to "false" (replaced with null to save memory)
		{
			send(sender, message);
		}
	}

	/**
	 * Send the selected enum message to a player or console with an
	 * overwriteable message.<br>
	 * The customMessage has priority if it's not null.<br>
	 * If the priority message is "false" it will not be displayed.<br>
	 * Additionally you can specify variables to replace in the message.<br>
	 * The variable param must be a 2D String array that has pairs of 2 strings,
	 * variable and replacement value.
	 * 
	 * @param sender
	 *            player or console
	 * @param customMessage
	 *            overwrite message, ignored if null, don't display if "false"
	 * @param variables
	 *            the variables array
	 */
	public void print(CommandSender sender, String customMessage, Object... variables) {

		if (sender == null) {
			return;
		}

		String msg = message;

		if (customMessage != null) // has custom message
		{
			if (customMessage.equals("false")) // if custom message is set to "false" then don't show the message
			{
				return;
			}

			msg = customMessage;
		}
		else if (msg == null) // message is "false", don't show the message
		{
			return;
		}

		msg = Tools.replaceVariables(msg, variables);

		send(sender, msg);
	}

	/**
	 * Send this message only once per connection.
	 * 
	 * @param sender
	 */
	public void printOnce(CommandSender sender) {

		printOnce(sender, null);
	}

	/**
	 * Send this message only once per connection.
	 * 
	 * @param sender
	 * @param customMessage
	 * @param variables
	 */
	public void printOnce(CommandSender sender, String customMessage, Object... variables) {

		if (sender == null) {
			return;
		}

		Set<String> set = sent.get(sender.getName());

		if (set == null) {
			set = new HashSet<String>();
			sent.put(sender.getName(), set);
		}

		if (!set.contains(path)) {
			set.add(path);
			print(sender, customMessage, variables);
		}
	}

	protected static void clearPlayer(String name) {

		sent.remove(name);
	}

	/**
	 * Sends an array of messages to a player or console.<br>
	 * Message supports &lt;color&gt; codes.
	 * 
	 * @param sender
	 * @param messages
	 */
	public static void send(CommandSender sender, String[] messages) {

		if (sender == null) {
			for (String s : messages)
				log(s);
		}

		for (String message : messages) {
			message = Tools.parseColors(message, false);
		}

		sender.sendMessage(messages);
	}

	/**
	 * Sends a message to a player or console.<br>
	 * Message supports &lt;color&gt; codes.
	 * 
	 * @param sender
	 * @param message
	 */
	public static void send(CommandSender sender, String message) {

		if (sender == null) {
			log(message);
		}

		sender.sendMessage(Tools.parseColors(message, (sender instanceof ConsoleCommandSender && !RecipeManager.getSettings().COLOR_CONSOLE)));
	}

	public static void sendAndLog(CommandSender sender, String message) {

		if (sender instanceof Player) {
			send(sender, message);
		}

		info(message);
	}

	public static void sendDenySound(Player player, Location location) {

		sendSound(player, location, Sound.NOTE_BASS, 0.8f, 4, RecipeManager.getSettings().SOUNDS_FAILED_CLICK);
	}

	public static void sendFailSound(Player player, Location location) {

		sendSound(player, location, Sound.NOTE_PLING, 0.8f, 4, RecipeManager.getSettings().SOUNDS_FAILED);
	}

	public static void sendRepairSound(Player player, Location location) {

		sendSound(player, location, Sound.ANVIL_USE, 0.8f, 4, RecipeManager.getSettings().SOUNDS_REPAIR);
	}

	private static void sendSound(Player player, Location location, Sound sound, float volume, float pitch, boolean condition) {

		/* if(player != null && condition) { player.playSound(location == null ?
		 * player.getLocation() : location, sound, volume, pitch); } */
	}

	/**
	 * Used by plugin to log messages, shouldn't be used by other plugins unless
	 * really needed to send e message tagged by RecipeManager
	 * 
	 * @param message
	 */
	public static void info(String message) {

		log(message);
	}

	public static void log(String message) {

		RecipeManager.getPlugin().getLogger().info(Tools.parseColors(message, true));
	}

	public static void error(CommandSender sender, Throwable thrown, String message) {

		try {
			message = "<red>" + (message == null ? thrown.getMessage() : message + " (" + thrown.getMessage() + ")");
			//sendAndLog(sender, message);
			notifyDebuggers(message);

			thrown.printStackTrace();

		}
		catch (Throwable e) {
			System.out.print("Error while printing error !");
			System.out.print("Initial error:");
			thrown.printStackTrace();

			System.out.print("Error printing error:");
			e.printStackTrace();

		}
	}

	/**
	 * Notifies all online operators and people having "recipemanager.debugger"
	 * permission
	 * 
	 * @param message
	 */
	protected static void notifyDebuggers(String message) {

		message = ChatColor.DARK_RED + "(RecipeManager debug) " + ChatColor.RESET + message;

		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission("recipemanager.debugger")) {
				send(p, message);
			}
		}
	}

	public static void debug(String message) {

		StackTraceElement[] e = new Exception().getStackTrace();
		int i = 1;
		Bukkit.getConsoleSender().sendMessage(Tools.parseColors(ChatColor.GREEN + "[DEBUG]" + ChatColor.AQUA + "" + ChatColor.UNDERLINE + e[i].getFileName() + ":" + e[i].getLineNumber() + ChatColor.RESET + " " + ChatColor.RED + e[i].getMethodName() + "() " + ChatColor.WHITE + Tools.parseColors(message, false), false));
	}
}

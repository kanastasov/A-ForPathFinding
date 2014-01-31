package worldMap;

/**
 * Before use the world map, we need a map loader.	
 * @author ForexMaster
 *
 */
public interface WorldMapLoader {

	WorldMap load(String filePath);
}

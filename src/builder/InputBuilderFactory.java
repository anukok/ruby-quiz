package builder;


public class InputBuilderFactory {

	static CharacterInputBuilder characterBuilder = new CharacterInputBuilder();
	
	public static CharacterInputBuilder getCharacterInputBuilder(){
		
		return characterBuilder;
	}
	
	public static CharacterInputBuilder getIntegerInputBuilder(){
		
		return characterBuilder;
	}
}

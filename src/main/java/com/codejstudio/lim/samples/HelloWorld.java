package com.codejstudio.lim.samples;

import java.io.IOException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.concept.Concept;
import com.codejstudio.lim.pojo.statement.Statement;

/**
 * sample: HelloWorld
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.concept.Concept
 * @see     com.codejstudio.lim.pojo.statement.Statement
 * @since   lim4j_v1.0.0
 */
public class HelloWorld {
	
	private static final String CLASS_NAME = HelloWorld.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, IOException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, IOException {
		Statement s1 = new Statement("Hello, world!");
		
		Concept c1 = new Concept("hello");
		Concept c2 = new Concept(",");
		Concept c3 = new Concept("world");
		Concept c4 = new Concept("!");
		Concept c5 = new Concept("H");
		Concept c6 = new Concept("h");
		Concept c7 = new Concept("e");
		Concept c8 = new Concept("l");
		Concept c9 = new Concept("o");
		Concept c10 = new Concept("w");
		Concept c11 = new Concept("r");
		Concept c12 = new Concept("d");
		
		s1.addConcept(c1, c2, c3, c4, c5);
		c1.addSubConcept(c6, c7, c8, c9);
		c3.addSubConcept(c10, c9, c11, c8, c12);
		
		Root root = new Root(s1);


		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(HelloWorld.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}

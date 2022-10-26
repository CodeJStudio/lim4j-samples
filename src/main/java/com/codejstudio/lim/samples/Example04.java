package com.codejstudio.lim.samples;

import java.io.FileNotFoundException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.Proposition;

/**
 * sample: Example04 
 * in "Theory of Logical Information Model & Logical Information Network"
 * from https://github.com/jhjiang/lim_lin
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @see     com.codejstudio.lim.pojo.Root
 * @see     com.codejstudio.lim.pojo.argument.Argument
 * @see     com.codejstudio.lim.pojo.statement.JudgedStatement
 * @see     com.codejstudio.lim.pojo.statement.Proposition
 * @since   lim4j_v1.0.0
 */
public class Example04 {
	
	private static final String CLASS_NAME = Example04.class.getSimpleName();
	
	private static final String INPUT_FILE_PATH = "/samples/" + CLASS_NAME + ".xml";
	
	private static final String OUTPUT_FILE_PATH = "";//e.g. "d:/" + CLASS_NAME + ".xml"

	public static void main(String[] args) throws LIMException, FileNotFoundException {
		doXmlMarshal();
//		doXmlUnmarshal();
	}

	private static void doXmlMarshal() throws LIMException, FileNotFoundException {
		Argument a1 = new Argument("① The Big Bang theory is crumbling .... "
				+ "② According to orthodox wisdom, the cosmos began with the Big Bang-an immense, perfectly symmetrical explosion 20 billion years ago. "
				+ "③ (The problem is that) astronomers have confirmed by observation the existence of huge conglomerations of galaxies that are simply too big to have been formed in a mere 20 billion years .... "
				+ "④ (Studies based on new data collected by satellite, and backed up by earlier ground surveys, show that) galaxies are clustered into vast ribbons that stretch billions of light years, "
				+ "⑤ and are separated by voids hundreds of millions of light years across. "
				+ "⑥ Galaxies are observed to travel at only a small fraction of the speed of light. "
				+ "⑦ Mathematics shows that such large clumps of matter must have taken at least one hundred billion years to come together -- five times as long as the time since the hypothetical Big Bang.");

		Argument a2 = new Argument("④ (Studies based on new data collected by satellite, and backed up by earlier ground surveys, show that) galaxies are clustered into vast ribbons that stretch billions of light years, "
				+ "⑤ and are separated by voids hundreds of millions of light years across. "
				+ "⑥ Galaxies are observed to travel at only a small fraction of the speed of light. "
				+ "⑦ Mathematics shows that such large clumps of matter must have taken at least one hundred billion years to come together -- five times as long as the time since the hypothetical Big Bang.");

		Argument a3 = new Argument("③ Astronomers have confirmed by observation the existence of huge conglomerations of galaxies that are simply too big to have been formed in a mere 20 billion years .... "
				+ "⑦ Mathematics shows that such large clumps of matter must have taken at least one hundred billion years to come together -- five times as long as the time since the hypothetical Big Bang.");

		Argument a4 = new Argument("① The Big Bang theory is crumbling .... "
				+ "② According to orthodox wisdom, the cosmos began with the Big Bang-an immense, perfectly symmetrical explosion 20 billion years ago. "
				+ "③ (The problem is that) astronomers have confirmed by observation the existence of huge conglomerations of galaxies that are simply too big to have been formed in a mere 20 billion years .... ");

		JudgedStatement js1 = new Proposition("The Big Bang theory is crumbling.");
		JudgedStatement js2 = new Proposition("According to orthodox wisdom, the cosmos began with the Big Bang-an immense, perfectly symmetrical explosion 20 billion years ago.");
		JudgedStatement js3 = new Proposition("Astronomers have confirmed by observation the existence of huge conglomerations of galaxies that are simply too big to have been formed in a mere 20 billion years.");
		JudgedStatement js4 = new Proposition("(Studies based on new data collected by satellite, and backed up by earlier ground surveys, show that) galaxies are clustered into vast ribbons that stretch billions of light years,");
		JudgedStatement js5 = new Proposition("Galaxies are separated by voids hundreds of millions of light years across.");
		JudgedStatement js6 = new Proposition("Galaxies are observed to travel at only a small fraction of the speed of light.");
		JudgedStatement js7 = new Proposition("Mathematics shows that such large clumps of matter must have taken at least one hundred billion years to come together -- five times as long as the time since the hypothetical Big Bang.");

		a2.addEvidence(js4, js5, js6);
		a2.addConclusion(js7);
		a3.addEvidence(js7);
		a3.addConclusion(js3);
		a4.addEvidence(js2, js3);
		a4.addConclusion(js1);
		a1.addSubArgument(a2, a3, a4);

		Root root = new Root(a1);

		
		
		root.marshalToXml(true, System.out);
		
		//set OUTPUT_FILE_PATH first, before opening below comment code
//		root.marshalToXml(true, new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH)));
	}

	private static void doXmlUnmarshal() throws LIMException {
		Root root = Root.unmarshalFromXml(Example04.class.getResource(INPUT_FILE_PATH));
		root.redecorate();
		root.marshalToXml(true, System.out);
	}

}

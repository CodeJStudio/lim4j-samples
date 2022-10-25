package com.codejstudio.lim.samples;

import java.io.IOException;

import com.codejstudio.lim.common.exception.LIMException;
import com.codejstudio.lim.pojo.AbstractElement;
import com.codejstudio.lim.pojo.OwnableInformationElement;
import com.codejstudio.lim.pojo.OwnableInformationElementGroup;
import com.codejstudio.lim.pojo.AbstractRelationableInformationElement;
import com.codejstudio.lim.pojo.BaseElement;
import com.codejstudio.lim.pojo.InformationElement;
import com.codejstudio.lim.pojo.InformationElementGroup;
import com.codejstudio.lim.pojo.InformationSection;
import com.codejstudio.lim.pojo.InformationUnit;
import com.codejstudio.lim.pojo.InformationUnitGroup;
import com.codejstudio.lim.pojo.Root;
import com.codejstudio.lim.pojo.argument.Argument;
import com.codejstudio.lim.pojo.argument.ArgumentGroup;
import com.codejstudio.lim.pojo.argument.HypotheticalSyllogism;
import com.codejstudio.lim.pojo.argument.MixedHypotheticalSyllogism;
import com.codejstudio.lim.pojo.argument.PureHypotheticalSyllogism;
import com.codejstudio.lim.pojo.argument.Syllogism;
import com.codejstudio.lim.pojo.argument.Validity;
import com.codejstudio.lim.pojo.attribute.Attribute;
import com.codejstudio.lim.pojo.attribute.AttributeGroup;
import com.codejstudio.lim.pojo.attribute.DefaultAttribute;
import com.codejstudio.lim.pojo.comment.Comment;
import com.codejstudio.lim.pojo.comment.CommentGroup;
import com.codejstudio.lim.pojo.concept.Concept;
import com.codejstudio.lim.pojo.concept.ConceptGroup;
import com.codejstudio.lim.pojo.condition.Condition;
import com.codejstudio.lim.pojo.condition.ConditionGroup;
import com.codejstudio.lim.pojo.condition.FactorCondition;
import com.codejstudio.lim.pojo.condition.HypotheticalCondition;
import com.codejstudio.lim.pojo.condition.NegativesCondition;
import com.codejstudio.lim.pojo.condition.PremiseCondition;
import com.codejstudio.lim.pojo.condition.QuantifiersCondition;
import com.codejstudio.lim.pojo.condition.ScopeCondition;
import com.codejstudio.lim.pojo.doubt.Doubt;
import com.codejstudio.lim.pojo.doubt.Explanation;
import com.codejstudio.lim.pojo.doubt.ExplanationGroup;
import com.codejstudio.lim.pojo.entity.Entity;
import com.codejstudio.lim.pojo.entity.EntityGroup;
import com.codejstudio.lim.pojo.i.IGroupable;
import com.codejstudio.lim.pojo.i.IIntegratable;
import com.codejstudio.lim.pojo.i.IOwnable;
import com.codejstudio.lim.pojo.i.IRelationable;
import com.codejstudio.lim.pojo.relation.AffiliationRelation;
import com.codejstudio.lim.pojo.relation.AnalogyRelation;
import com.codejstudio.lim.pojo.relation.AntonymyRelation;
import com.codejstudio.lim.pojo.relation.AttributeMappingRelation;
import com.codejstudio.lim.pojo.relation.BaseRelation;
import com.codejstudio.lim.pojo.relation.CausalityRelation;
import com.codejstudio.lim.pojo.relation.ComparisonRelation;
import com.codejstudio.lim.pojo.relation.CustomizedRelation;
import com.codejstudio.lim.pojo.relation.DefiningRelation;
import com.codejstudio.lim.pojo.relation.DoubtNExplanationRelation;
import com.codejstudio.lim.pojo.relation.EquivalenceRelation;
import com.codejstudio.lim.pojo.relation.GreaterThanRelation;
import com.codejstudio.lim.pojo.relation.LessThanRelation;
import com.codejstudio.lim.pojo.relation.MappingRelation;
import com.codejstudio.lim.pojo.relation.NearSynonymyRelation;
import com.codejstudio.lim.pojo.relation.PredicateMappingRelation;
import com.codejstudio.lim.pojo.relation.RelationGroup;
import com.codejstudio.lim.pojo.relation.SemanticRelation;
import com.codejstudio.lim.pojo.relation.SynonymyRelation;
import com.codejstudio.lim.pojo.role.BaseRole;
import com.codejstudio.lim.pojo.role.Observer;
import com.codejstudio.lim.pojo.role.ObserverGroup;
import com.codejstudio.lim.pojo.role.Proposer;
import com.codejstudio.lim.pojo.statement.Definition;
import com.codejstudio.lim.pojo.statement.HypotheticalProposition;
import com.codejstudio.lim.pojo.statement.JudgedStatement;
import com.codejstudio.lim.pojo.statement.JudgedStatementGroup;
import com.codejstudio.lim.pojo.statement.Narration;
import com.codejstudio.lim.pojo.statement.Proposition;
import com.codejstudio.lim.pojo.statement.Statement;
import com.codejstudio.lim.pojo.statement.StatementGroup;
import com.codejstudio.lim.pojo.statement.Truth;

/**
 * POJO naming samples
 * 
 * @author <ul><li>Jeffrey Jiang</li></ul>
 * @since   lim4j_v1.0.0
 */
public class PojoNamingSample {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) throws LIMException, IOException {
		Root root;
		
		BaseElement be;
		AbstractElement ae;
		OwnableInformationElement oie;
		OwnableInformationElementGroup oieg;
		AbstractRelationableInformationElement arie;
		
		IGroupable igb;
		IIntegratable iib;
		IOwnable iob;
		IRelationable irb;
		
		InformationElement ie;
		InformationElementGroup ieg;
		InformationSection is;
		InformationUnit iu;
		InformationUnitGroup iug;
		
		Argument a;
		ArgumentGroup ag;
		Syllogism sy;
		HypotheticalSyllogism hsy;
		MixedHypotheticalSyllogism mhsy;
		PureHypotheticalSyllogism phsy;
		Validity v;
		
		Attribute at;
		AttributeGroup atg;
		DefaultAttribute dat;
		
		Concept c;
		ConceptGroup cg;
		
		Condition cd;
		ConditionGroup cdg;
		FactorCondition fcd;
		HypotheticalCondition hcd;
		PremiseCondition pcd;
		ScopeCondition scd;
		NegativesCondition ncd;
		QuantifiersCondition qcd;
		
		Doubt d;
		Explanation ex;
		ExplanationGroup exg;
		
		Statement s;
		StatementGroup sg;
		JudgedStatement js;
		JudgedStatementGroup jsg;
		Definition df;
		Narration nt;
		Proposition pp;
		HypotheticalProposition hpp;
		Truth t;
		
		BaseRelation br;
		RelationGroup rg;
		MappingRelation mpr;
		AnalogyRelation anr;
		AttributeMappingRelation ampr;
		PredicateMappingRelation pmpr;
		AffiliationRelation afr;
		CausalityRelation csr;
		CustomizedRelation ctr;
		DefiningRelation dfr;
		SynonymyRelation snr;
		AntonymyRelation atr;
		NearSynonymyRelation nsnr;
		DoubtNExplanationRelation der;
		EquivalenceRelation eqr;
		ComparisonRelation cpr;
		GreaterThanRelation gtr;
		LessThanRelation ltr;
		SemanticRelation smr;

		Entity e;
		EntityGroup eg;
		
		Comment cm;
		CommentGroup cmg;
		
		BaseRole bro;
		Observer o;
		ObserverGroup og;
		Proposer p;
		
	}

}

package org.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * @author winton
 * @since 2017-9-26
 */
public class LombokPlugin extends PluginAdapter {
	
	public static FullyQualifiedJavaType FULLYQUALIFIEDJAVATYPE; 
	
	public static Boolean lombokComment = false;
	
	public LombokPlugin() {
		FULLYQUALIFIEDJAVATYPE = new FullyQualifiedJavaType("java.io.Serializable");
		lombokComment = true;
	}
	
	@Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 添加lombok注解
		topLevelClass.addAnnotation("@Data");
		topLevelClass.addImportedType("lombok.Data");
		
		topLevelClass.addAnnotation("@Builder");
		topLevelClass.addImportedType("lombok.Builder");
		
		// 添加实现序列化接口
		topLevelClass.addSuperInterface(FULLYQUALIFIEDJAVATYPE);
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
}

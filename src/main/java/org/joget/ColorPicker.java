package org.joget;

import org.joget.apps.app.service.AppPluginUtil;
import org.joget.apps.app.service.AppUtil;
import org.joget.apps.form.model.Element;
import org.joget.apps.form.model.FormBuilderPalette;
import org.joget.apps.form.model.FormBuilderPaletteElement;
import org.joget.apps.form.model.FormData;
import org.joget.apps.form.service.FormUtil;

import java.util.Map;
import java.util.logging.Logger;

public class ColorPicker extends Element implements FormBuilderPaletteElement {
    private final static String PROPERTIES_PATH = "/properties/ColorPicker";
    private final static String JSON_PATH = "/properties/ColorPicker.json";

    Logger logger = Logger.getLogger(ColorPicker.class.getName());

    @Override
    public String renderTemplate(FormData formData, Map map) {
        String template = "colorPicker.ftl";
        String defaultValue = FormUtil.getElementPropertyValue(this, formData);
        map.put("defaultValue", "".equals(defaultValue) ? "#000" : defaultValue);
        String html = FormUtil.generateElementHtml(this, formData, template, map);
        return html;
    }

    @Override
    public String getFormBuilderCategory() {
        return FormBuilderPalette.CATEGORY_CUSTOM;
    }

    @Override
    public int getFormBuilderPosition() {
        return 0;
    }

    @Override
    public String getFormBuilderIcon() {
        return "/plugin/" + getClassName() + "/images/colorPicker_icon.gif";
    }

    @Override
    public String getFormBuilderTemplate() {
        return "<label class='label' style='color:red'>" + getLabel() + "</label>";
    }

    @Override
    public String getName() {
        return AppPluginUtil.getMessage("org.joget.ColorPicker.pluginName", getClassName(), PROPERTIES_PATH);
    }

    @Override
    public String getVersion() {
        return AppPluginUtil.getMessage("org.joget.ColorPicker.pluginVersion", getClassName(), PROPERTIES_PATH);

    }

    @Override
    public String getDescription() {
        return AppPluginUtil.getMessage("org.joget.ColorPicker.pluginDesc", getClassName(), PROPERTIES_PATH);
    }

    @Override
    public String getLabel() {
        return getName();
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getPropertyOptions() {
        return AppUtil.readPluginResource(getClassName(), JSON_PATH, null, true, PROPERTIES_PATH);
    }
}

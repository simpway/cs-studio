package org.csstudio.nams.configurator.treeviewer.model.treecomponents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.csstudio.nams.configurator.treeviewer.model.AbstractConfigurationBean;

public class AlarmbearbeitergruppenNode implements IConfigurationNode {

	private String name = "Alarmbearbeitergruppen";
	private Map<String, SortGroupBean> groupBeans;

	public AlarmbearbeitergruppenNode(Map<String, SortGroupBean> map) {
		this.groupBeans = map;
	}

	public Collection<AbstractConfigurationBean> getChildren() {
		Collection<AbstractConfigurationBean> alarmbearbeitergruppenBeans = new ArrayList<AbstractConfigurationBean>();

		/*
		 * Filter Alarmbearbeitergruppen-Beans heraus
		 */
		for (SortGroupBean bean : groupBeans.values()) {
			/*
			 * filter leere Gruppen heraus, diese werden im TreeViewer nicht
			 * angezeigt (Konvention laut DESY)
			 */
			if (!bean.getAlarmbearbeitergruppenBeans().isEmpty()) {
				alarmbearbeitergruppenBeans.addAll(bean
						.getAlarmbearbeitergruppenBeans());
			}
		}
		return alarmbearbeitergruppenBeans;
	}

	public String getName() {
		return name;
	}

}

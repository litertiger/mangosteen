/*******************************************************************************
 * Copyright (c) 2009, 2019 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/
package com.mangosteen.jacoco.report.internal.html.table;

import com.mangosteen.jacoco.core.analysis.ICoverageNode;
import com.mangosteen.jacoco.report.internal.ReportOutputFolder;
import com.mangosteen.jacoco.report.internal.html.HTMLElement;
import com.mangosteen.jacoco.report.internal.html.resources.Resources;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * Column for the item label. The implementation is stateless, instances might
 * be used in parallel.
 */
public class LabelColumn implements IColumnRenderer {

	private static final Comparator<ITableItem> COMPARATOR = new Comparator<ITableItem>() {
		public int compare(final ITableItem i1, final ITableItem i2) {
			return i1.getLinkLabel().compareToIgnoreCase(i2.getLinkLabel());
		}
	};

	public boolean init(final List<? extends ITableItem> items,
			final ICoverageNode total) {
		return true;
	}

	public void footer(final HTMLElement td, final ICoverageNode total,
			final Resources resources, final ReportOutputFolder base)
			throws IOException {
		td.text("Total");
	}

	public void item(final HTMLElement td, final ITableItem item,
			final Resources resources, final ReportOutputFolder base)
			throws IOException {
		td.a(item, base);
	}

	public Comparator<ITableItem> getComparator() {
		return COMPARATOR;
	}

}

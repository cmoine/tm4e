/**
 *  Copyright (c) 2015-2017 Angelo ZERR.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Initial code from https://github.com/atom/node-oniguruma
 * Initial copyright Copyright (c) 2013 GitHub Inc.
 * Initial license: MIT
 *
 * Contributors:
 *  - GitHub Inc.: Initial code, written in JavaScript, licensed under MIT license
 *  - Angelo Zerr <angelo.zerr@gmail.com> - translation and adaptation to Java
 */

package org.eclipse.tm4e.core.internal.oniguruma;

public class OnigScanner {

	private final OnigSearcher searcher;

	public OnigScanner(String[] regexps) {
		this.searcher = new OnigSearcher(regexps);
	}

	public IOnigNextMatchResult _findNextMatchSync(OnigString source, int charOffset) {
		OnigResult bestResult = searcher.search(source, charOffset);
		if (bestResult != null) {
			return new OnigNextMatchResult(bestResult, source);
		}
		return null;
	}

	public IOnigNextMatchResult _findNextMatchSync(String lin, int pos) {
		return _findNextMatchSync(new OnigString(lin), pos);
	}

}

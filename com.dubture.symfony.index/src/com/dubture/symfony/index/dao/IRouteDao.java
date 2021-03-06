/*******************************************************************************
 * This file is part of the Symfony eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.symfony.index.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.core.runtime.IPath;


/**
 * 
 * RouteDao Interface.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface IRouteDao {
	

	void insert(Connection connection, String name, String pattern, 
		String controller, String bundle, String action, IPath path)
			throws SQLException;

	void commitInsertions() throws SQLException;

	void deleteRoutesByPath(Connection connection, String name, IPath path);

	List<Route> findRoutes(Connection connection, IPath path);
	
	List<Route> findRoutes(Connection connection, String prefix, IPath path);
	
	List<Route> findRoutesByBundle(Connection connection, String bundle, IPath path);

	Route findRoute(Connection connection, String route, IPath path);
	

	List<Route> findRoutesByController(Connection connection,
			String bundleAlias, String controller, IPath path);

	void insertResource(Connection connection, String path, String type,
			String prefix, IPath fullPath);

}

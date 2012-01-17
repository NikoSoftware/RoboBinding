/**
 * Copyright 2012 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package sample.robobinding;

import sample.robobinding.store.AlbumStore;


/**
*
* @since 1.0
* @version $Revision: 1.0 $
* @author Robert Taylor
*/
public class EmptyListViewTest extends AbstractSampleAppTest 
{
    public void testDisplayTheEmptyView() 
    {
        clickOnButtonWithLabel(R.string.list_backed_albums);
        
        int albumCount = AlbumStore.getAll().size();
		for (int i = 0; i < albumCount; i++)
        {
            selectFirstItemInList();
            deleteAlbum();
        }
        
        assertTrue(solo.searchText(getString(R.string.albums_list_empty)));
    }

    private void deleteAlbum() 
    {
        clickOnButtonWithLabel(R.string.delete);
        
        clickOnButtonWithLabel(R.string.yes);
        
        solo.waitForDialogToClose(500);
    }
    
    protected void selectFirstItemInList()
    {
        scrollToTopOfList();
        solo.clickInList(0);
    }
    
    private void scrollToTopOfList()
    {
        while (solo.scrollUpList(0)){}
    }
}

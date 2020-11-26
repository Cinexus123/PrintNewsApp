import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { News } from './models/news.ts/news.ts.component';
import { ComponentComponent } from './component/component.component';
import { ModalComponent } from './modal/modal.component';
import { NewcontainerComponent } from './newcontainer/newcontainer.component';
import { NewsitemComponent } from './newsitem/newsitem.component';

@NgModule({
  declarations: [
    AppComponent,
    News.TsComponent,
    ComponentComponent,
    ModalComponent,
    NewcontainerComponent,
    NewsitemComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

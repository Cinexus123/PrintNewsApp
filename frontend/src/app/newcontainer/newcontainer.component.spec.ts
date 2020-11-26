import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewcontainerComponent } from './newcontainer.component';

describe('NewcontainerComponent', () => {
  let component: NewcontainerComponent;
  let fixture: ComponentFixture<NewcontainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewcontainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewcontainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

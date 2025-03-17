import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ManageMultipleOrdersComponent } from './manage-multiple-orders.component';

describe('ManageOrdersComponent', () => {
  let component: ManageMultipleOrdersComponent;
  let fixture: ComponentFixture<ManageMultipleOrdersComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageMultipleOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageMultipleOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

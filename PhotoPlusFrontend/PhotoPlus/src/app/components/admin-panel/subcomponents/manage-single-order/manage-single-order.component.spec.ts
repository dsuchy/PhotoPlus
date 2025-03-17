import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ManageSingleOrderComponent } from './manage-single-order.component';

describe('ManageSingleOrderComponent', () => {
  let component: ManageSingleOrderComponent;
  let fixture: ComponentFixture<ManageSingleOrderComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageSingleOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageSingleOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

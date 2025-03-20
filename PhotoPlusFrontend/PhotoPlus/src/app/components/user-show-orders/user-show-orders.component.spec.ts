import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { UserShowOrdersComponent } from './user-show-orders.component';

describe('UserShowOrdersComponent', () => {
  let component: UserShowOrdersComponent;
  let fixture: ComponentFixture<UserShowOrdersComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [UserShowOrdersComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserShowOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

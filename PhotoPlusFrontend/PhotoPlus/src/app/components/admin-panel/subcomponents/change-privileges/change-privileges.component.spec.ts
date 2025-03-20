import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ChangePrivilegesComponent } from './change-privileges.component';

describe('ChangePrivilegesComponent', () => {
  let component: ChangePrivilegesComponent;
  let fixture: ComponentFixture<ChangePrivilegesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangePrivilegesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangePrivilegesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

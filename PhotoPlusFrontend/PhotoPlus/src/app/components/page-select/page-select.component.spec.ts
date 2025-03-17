import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PageSelectComponent } from './page-select.component';

describe('PageSelectComponent', () => {
  let component: PageSelectComponent;
  let fixture: ComponentFixture<PageSelectComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ PageSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
